package com.example.tujipange.loanProcessing.Repositories;

import com.example.tujipange.loanProcessing.models.LoanProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nicholas Nzovia
 * @On 05/09/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Repository
public interface LoanProductRepository extends JpaRepository<LoanProduct, Long> {

}
