package com.example.symu_api.USER.Service;

import com.example.symu_api.COMMON.Model.SymuResponse;
import com.example.symu_api.USER.Entity.UserEntity;
import com.example.symu_api.USER.Model.UserModel;
import com.example.symu_api.USER.Repository.UserModelRepo;
import com.example.symu_api.USER.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserModelRepo userModelRepo;
    @Autowired
    private UserRepository userRepository;
    @Override
    public SymuResponse createOrUpdateUser(UserEntity userDao) {
        SymuResponse symuResponse=new SymuResponse<>();
        UserEntity userEntity=new UserEntity();
        try {
            try {
                UserEntity userEntityData=userRepository.getAllByCode(userDao.getCode());
                userEntity.setCode(userEntityData.getCode());
            }catch (Exception e){
                //new user
            }
            userEntity.setUserFirstName(userDao.getUserFirstName());
            userEntity.setUserLastName(userDao.getUserLastName());
            userEntity.setUserEmail(userDao.getUserEmail());
            userEntity.setUserPhone(userDao.getUserPhone());
            userEntity.setUserId(userDao.getUserId());
            userEntity.setUserHudumaNo(userDao.getUserHudumaNo());
            userEntity.setUserPassword(userDao.getUserPassword());
            userEntity.setUserRoleCode(userDao.getUserRoleCode());
            userEntity.setUserCompanyCode(userDao.getUserCompanyCode());
            userEntity.setUserBrnCode(userDao.getUserBrnCode());
            userEntity.setUserCountryCode(userDao.getUserCountryCode());
            UserEntity entitySaved=userRepository.save(userEntity);
            symuResponse.setStatusCode("0");
            symuResponse.setMessage("Success");
            symuResponse.setData(entitySaved);
        }catch (Exception e){
            symuResponse.setStatusCode("1");
            symuResponse.setMessage("failed");
            symuResponse.setData(e.getMessage());
        }
        return symuResponse;
    }
    @Override
    public SymuResponse getAllByCode(int code) {
        SymuResponse symuResponse=new SymuResponse<>();
        try{
            UserEntity userEntity=userRepository.getAllByCode(code);
            symuResponse.setStatusCode("0");
            symuResponse.setMessage("Success");
            symuResponse.setData(userEntity);
        }catch (Exception e){
            symuResponse.setStatusCode("1");
            symuResponse.setMessage("failed");
            symuResponse.setData(e.getMessage());
        }
        return symuResponse;
    }

    @Override
    public SymuResponse getAllById(int idNo) {
        SymuResponse symuResponse=new SymuResponse<>();
        try{
            UserEntity userEntity=userRepository.getAllByUserId(idNo);
            symuResponse.setStatusCode("0");
            symuResponse.setMessage("Success");
            symuResponse.setData(userEntity);
        }catch (Exception e){
            symuResponse.setStatusCode("1");
            symuResponse.setMessage("failed");
            symuResponse.setData(e.getMessage());
        }
        return symuResponse;
    }

    @Override
    public SymuResponse getAllByUserRoleCode(int roleCode) {
        SymuResponse symuResponse=new SymuResponse<>();
        try{
            List<UserEntity> userEntity=userRepository.getAllByUserRoleCode(roleCode);
            symuResponse.setStatusCode("0");
            symuResponse.setMessage("Success");
            symuResponse.setData(userEntity);
        }catch (Exception e){
            symuResponse.setStatusCode("1");
            symuResponse.setMessage("failed");
            symuResponse.setData(e.getMessage());
        }
        return symuResponse;
    }

    @Override
    public SymuResponse getAllByUserBrnCode(int brnCode) {
        SymuResponse symuResponse=new SymuResponse<>();
        try{
            List<UserEntity> userEntity=userRepository.getAllByUserBrnCode(brnCode);
            symuResponse.setStatusCode("0");
            symuResponse.setMessage("Success");
            symuResponse.setData(userEntity);
        }catch (Exception e){
            symuResponse.setStatusCode("1");
            symuResponse.setMessage("failed");
            symuResponse.setData(e.getMessage());
        }
        return symuResponse;
    }

    @Override
    public SymuResponse getAllByUserIdAndUserPassword(int idNo, String password) {
        SymuResponse symuResponse=new SymuResponse<>();
        try{
            UserModel userEntity=userModelRepo.getAllByUserIdAndUserPassword(idNo,password);
            symuResponse.setStatusCode("0");
            symuResponse.setMessage("Success");
            symuResponse.setData(userEntity);
        }catch (Exception e){
            symuResponse.setStatusCode("1");
            symuResponse.setMessage("failed");
            symuResponse.setData(e.getMessage());
        }
        return symuResponse;
    }
}
