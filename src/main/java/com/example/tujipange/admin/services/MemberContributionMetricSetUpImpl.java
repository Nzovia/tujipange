package com.example.tujipange.admin.services;

import com.example.tujipange.admin.dtos.ContributionMetricDto;
import com.example.tujipange.admin.enums.ContributionSpans;
import com.example.tujipange.admin.models.MemberContributionMetric;
import com.example.tujipange.admin.repositories.MemberMetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nicholas Nzovia
 * @On 19/05/2023
 * @Contact: itsdevelopernic22@gmail.com
 */
@Service
public class MemberContributionMetricSetUpImpl implements MemberContributionMetricSetUp {
    @Autowired
    private MemberMetricRepository memberMetricRepository;

    @Override
    public String createContributionMetric(ContributionMetricDto request) {
        MemberContributionMetric contributionMetric = new MemberContributionMetric();
        contributionMetric.setContributionAmount(request.getContributionAmount());
        contributionMetric.setDueDate(request.getDueDate());
        contributionMetric.setPeriodEnum(ContributionSpans.valueOf(request.getPeriodEnum()));
        contributionMetric.setPenaltyPercentage(request.getPenaltyPercentage());
        contributionMetric.setSavingsPercentage(request.getSavingsPercentage());
        contributionMetric.setMerryGoRoundPercentage(request.getMerryGoRoundPercentage());

        try{
            memberMetricRepository.save(contributionMetric);
        }
        catch(DataAccessException e){
            e.getMessage();
        }
     return "Metric added";
    }

    @Override
    public MemberContributionMetric updateContributionMetric(Long metricId, ContributionMetricDto updateRequest) {
       //get the existing metric
       MemberContributionMetric contributionMetric = memberMetricRepository.findByMetricCode(updateRequest.getMetricCode());

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
    public String deleteContributionMetric(Long metricId) {
        String deletionMessage = "";
       try{
           memberMetricRepository.deleteById(metricId);
           return  deletionMessage;
       }catch (Exception ex){
           return ex.getMessage();
       }
    }

    @Override
    public List<MemberContributionMetric> getAllContributionMetrics() {
        return memberMetricRepository.findAll();
    }
}
