package kg.apps.CBMapp.security;

import kg.apps.CBMapp.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class CustomUserDetails extends User implements UserDetails {

    private final Set<GrantedAuthority> authorities=new HashSet<>();

    public CustomUserDetails(final User users) {
        super(users.getUsername(),users.getPassword(),users.getName(),users.getSurname(),users.getEmail(),users.getAddress(),users.getPhone(),users.getActive());
        authorities.add(new SimpleGrantedAuthority("User"));
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {


        /*return getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole()))
                .collect(Collectors.toList());*/
        return authorities;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
