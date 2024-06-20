package com.ras.ras_test.service.impl;

import com.ras.ras_test.dto.PaymentDto;
import com.ras.ras_test.exception.BusinessException;
import com.ras.ras_test.exception.NotFoundException;
import com.ras.ras_test.mapper.CreditCardMapper;
import com.ras.ras_test.model.CreditCardModel;
import com.ras.ras_test.repository.CreditCardRepository;
import com.ras.ras_test.repository.CustomerRepository;
import com.ras.ras_test.repository.OrderRepository;
import com.ras.ras_test.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final CreditCardRepository creditCardRepository;

    private final CustomerRepository customerRepository;

    private final OrderRepository orderRepository;

    @Autowired
    PaymentServiceImpl(CreditCardRepository creditCardRepository, CustomerRepository customerRepository,
                       OrderRepository orderRepository) {
        this.creditCardRepository = creditCardRepository;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Boolean process(PaymentDto paymentDto) {

        if (orderRepository.findById(paymentDto.getOrderId()).isEmpty()) {
            throw new NotFoundException("Pedido não encontrado");
        }

        var customer = customerRepository.findById(paymentDto.getCustomerId());
        if (customer.isEmpty()) {
            throw new NotFoundException("Cliente não encontrado");
        }

        var ccList = creditCardRepository.findByNumber(paymentDto.getCreditCard().getNumber());
        CreditCardModel ccModel = CreditCardMapper.fromDtoToModel(paymentDto.getCreditCard(), paymentDto.getCustomerId());
        if (ccList.isEmpty()) {
            creditCardRepository.save(ccModel);
        } else {
            ccList.forEach(creditCardModel -> {
                if (!creditCardModel.getCustomerId().equals(paymentDto.getCustomerId()) &&
                        !creditCardModel.getDocumentNumber().equals(customer.get().getCpf())) {
                    throw new BusinessException("Pagamento negado pela processadora", HttpStatus.UNAUTHORIZED);
                } else if (!creditCardModel.getCustomerId().equals(paymentDto.getCustomerId()) &&
                        creditCardModel.getDocumentNumber().equals(customer.get().getCpf())) {
                    creditCardRepository.save(ccModel);
                }
            });

        }
        return true;
    }
}
