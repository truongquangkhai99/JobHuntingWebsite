/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobhunting.service.impl;

import com.jobhunting.pojo.Recruit;
import com.jobhunting.pojo.RecruitJob;
import com.jobhunting.repository.RecruitJobRepository;
import com.jobhunting.service.RecruitJobService;
import java.text.ParseException;
import java.util.List;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import java.text.SimpleDateFormat; 
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
@Service
public class RecruitJobServiceImpl implements RecruitJobService{
    @Autowired
    public RecruitJobRepository recruitJobRepository;
//    @Autowired
//    private Cloudinary cloudinary;
    
    @Override
    public List<RecruitJob> getRecruitJob() {
        return this.recruitJobRepository.getRecruitJob();
    }

    @Override
    public List<RecruitJob> getRecruitJobBySearching(Integer cityId, Integer professionId, Integer workTypeId, Integer salaryId) {
        return this.recruitJobRepository.getRecruitJobBySearching(cityId, professionId, workTypeId, salaryId);
    }

    @Override
    public RecruitJob getRecruitJobById(Integer intgr) {
        return this.recruitJobRepository.getRecruitJobById(intgr);
    }

    @Override
    public Object getJobDetail(Integer intgr) {
        return this.recruitJobRepository.getJobDetail(intgr);
    }

    @Override
    public List<RecruitJob> getRecruitJobByRecruitId(Integer intgr) {
        return this.recruitJobRepository.getRecruitJobByRecruitId(intgr);
    }

    @Override
    public List<RecruitJob> getRecruitJobByKW(String string) {
        return this.recruitJobRepository.getRecruitJobByKW(string);
    }

    @Override
    public boolean addOrUpdate(RecruitJob rj) {
//        long miliseconds = System.currentTimeMillis();
        Date date = new Date();  
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        rj.setPostDate(date);
//        try {
//            rj.setExpirationDate(simpleDateFormat.parse("21/2/2022"));
//        } catch (ParseException ex) {
//            Logger.getLogger(RecruitJobServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
        rj.setStatus(true);
//        try {
//            Map r = this.cloudinary.uploader().upload(recruitJob.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
//            Product.setImage((String) r.get("secure_url"));
              return this.recruitJobRepository.addOrUpdate(rj);
//        } catch (Exception ex) {
//            System.err.println("==ADD RECRUIT JOB ERROR== "+ ex.getMessage());
//            ex.printStackTrace();
//        }
//        return false;
    }

    @Override
    public boolean deleteRecruitJob(Integer id) {
        RecruitJob r = this.recruitJobRepository.getRecruitJobById(id);
        return this.recruitJobRepository.deleteRecruitJob(r);
    }
    
}
