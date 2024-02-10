package com.example.tujipange.loanProcessing.services;

import com.example.tujipange.loanProcessing.models.LoanProduct;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nicholas Nzovia
 * @On 04/09/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

/*
* An interface for the LoanProduct Service that is concerned with
* Creation, update,  Deletion and filter of the Loan Products
* */
@Service
public interface LoanProductService {
    LoanProduct addNewLoadProduct(LoanProduct loanProduct);
    Boolean activateLoanProduct(String productCode);
    List<LoanProduct> getAllLoanProductDetails();
    Void updateASpecificLoanProductBasedOnTheProductCode(String productCode);

}
