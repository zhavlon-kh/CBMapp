package kg.apps.CBMapp.service.impl;

import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.model.ContactMobile;
import kg.apps.CBMapp.repository.ContactMobileRepository;
import kg.apps.CBMapp.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MobileServiceImpl implements MobileService {

    @Autowired
    ContactMobileRepository mobileRepository;

    @Override
    public Set<ContactMobile> selectAllMobilesByContact(Contact contact) {
        return mobileRepository.getAllByContact(contact);
    }

    @Override
    public void deleteMobile(ContactMobile mobile) {
        mobileRepository.delete(mobile);
    }

    @Override
    public void deleteMobileById(Long id) {
        deleteMobileById(id);
    }

    @Override
    public void addMobile(ContactMobile mobile) {
        mobileRepository.save(mobile);
    }

    @Override
    public void deleteMobiles(Iterable<ContactMobile> mobiles) {
        mobileRepository.deleteAll(mobiles);
    }
}
