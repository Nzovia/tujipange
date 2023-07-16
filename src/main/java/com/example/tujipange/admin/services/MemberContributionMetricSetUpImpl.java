package com.example.tujipange.admin.services;

import com.example.tujipange.admin.dtos.ContributionMetricDto;
import com.example.tujipange.admin.enums.ContributionSpans;
import com.example.tujipange.admin.models.MemberContributionMetric;
import com.example.tujipange.admin.repositories.MemberMetricRepository;
import com.example.tujipange.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * @author Nicholas Nzovia
 * @On 19/05/2023
 * @Contact: itsdevelopernic22@gmail.com
 */
@Service
@Slf4j
public class MemberContributionMetricSetUpImpl implements MemberContributionMetricSetUp {
    @Autowired
    private MemberMetricRepository memberMetricRepository;

    @Override
    public String createContributionMetric(ContributionMetricDto request) {
        try {
            MemberContributionMetric contributionMetric = new MemberContributionMetric();

            contributionMetric.setContributionAmount(request.getContributionAmount());
            contributionMetric.setDueDate(request.getDueDate());
            contributionMetric.setMetricCode(request.getMetricCode());
            contributionMetric.setPeriodEnum(ContributionSpans.valueOf(request.getPeriodEnum()));
            contributionMetric.setPenaltyPercentage(request.getPenaltyPercentage());
            contributionMetric.setSavingsPercentage(request.getSavingsPercentage());
            contributionMetric.setMerryGoRoundPercentage(request.getMerryGoRoundPercentage());

            var savedMetric = memberMetricRepository.save(contributionMetric);
            log.info("Here saving the object ",savedMetric);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return "Metric added";
    }

    @Override
    public MemberContributionMetric updateContributionMetric(Long metricId, ContributionMetricDto updateRequest) throws EntityNotFoundException {
        //get the existing metric
        MemberContributionMetric contributionMetric = memberMetricRepository.findById(metricId).get();

        if(contributionMetric.equals(null)){
            //check whether the records exist
            contributionMetric.setMetricCode(updateRequest.getMetricCode());
            contributionMetric.setContributionAmount(updateRequest.getContributionAmount());
            contributionMetric.setPeriodEnum(ContributionSpans.valueOf(updateRequest.getPeriodEnum()));
            contributionMetric.setDueDate(updateRequest.getDueDate());
            contributionMetric.setPenaltyPercentage(updateRequest.getPenaltyPercentage());
            contributionMetric.setSavingsPercentage(updateRequest.getSavingsPercentage());
            contributionMetric.setMerryGoRoundPercentage(contributionMetric.getMerryGoRoundPercentage());

            var updatedContributionMeteric = memberMetricRepository.save(contributionMetric);

            return updatedContributionMeteric;
        }else {
            throw  new EntityNotFoundException("Metric not found by the ID" + metricId);
        }


    }

    @Override
    public String deleteContributionMetric(Long metricId) throws ResourceNotFoundException {
        String deletionMessage = "";
        try {
            MemberContributionMetric memberContributionMetric = memberMetricRepository.findById(metricId)
                            .orElseThrow(() -> new ResourceNotFoundException("Referenced Metric not found: " + metricId));
            memberMetricRepository.delete(memberContributionMetric);
            return deletionMessage;
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @Override
    public List<MemberContributionMetric> getAllContributionMetrics() {
        return memberMetricRepository.findAll();
    }
}
