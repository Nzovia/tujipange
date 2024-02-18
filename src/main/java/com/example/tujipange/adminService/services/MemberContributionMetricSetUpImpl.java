package com.example.tujipange.adminService.services;

import com.example.tujipange.adminService.dtos.ContributionMetricDto;
import com.example.tujipange.adminService.enums.ContributionSpans;
import com.example.tujipange.adminService.models.MemberContributionMetric;
import com.example.tujipange.adminService.repositories.MemberMetricRepository;
import com.example.tujipange.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
            log.info("Here saving the object ", savedMetric);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return "Metric added";
    }

    @Override
    public MemberContributionMetric updateContributionMetric(Long metricId, ContributionMetricDto updateRequest) throws ResourceNotFoundException {
        //get the existing metric
        MemberContributionMetric contributionMetric = memberMetricRepository.findById(metricId).orElseThrow(
                () -> new ResourceNotFoundException("Metric not found by the ID: " + metricId)
        );
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


    }

    @Override
    public String deleteContributionMetric(Long metricId) throws ResourceNotFoundException {
        String deletionMessage = "Record deleted successfully";
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

    @Override
    public Optional<ContributionMetricDto> getActiveContributionMetric(boolean active) {
        try{
            Optional<ContributionMetricDto> contributionMetricDto = memberMetricRepository.findByStatus(active);

            if(contributionMetricDto.isPresent()){
                return contributionMetricDto;
            }else{
                return Optional.of(new ContributionMetricDto("No active metric record"));
            }
        }catch (Exception exception){
            return Optional.of(new ContributionMetricDto("Error occurred: "+ exception.getMessage()));
        }

    }


}
