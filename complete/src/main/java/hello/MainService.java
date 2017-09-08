package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jack on 2017/9/4.
 */
@Service
//@Transactional
public class MainService {

    @Autowired
    private UserRepository userRepository;

    /**
     * try to test the tranditonal annotation
     */
    public void insertAndDelete(){
        //这里应该会因为下面失败之后回滚
        User userDel = new User();
        userDel.setId(2);
        userDel.setName("name2");
        userDel.setEmail("email2");
        userRepository.delete(userDel);
        //应该这里应该没有值了，所以会报异常
        //这里应该会报异常，导致回滚
        User uuu = null;
        userRepository.delete(uuu);
    }

}
