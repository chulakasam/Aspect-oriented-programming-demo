package lk.ijse.afterreturningadvice.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {
    @Override
    public String getFortune() {
        //simulate delay

        try{
            TimeUnit.SECONDS.sleep(5);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        //return fortune
        return "expect heavy traffic in the morning";
    }

    @Override
    public String getFortune(boolean triWire) {
       if(triWire){
           throw  new RuntimeException("major accident ! highway is closed");
       }
       return getFortune();
    }
}
