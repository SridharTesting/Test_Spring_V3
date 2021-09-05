/*
 * package com.slk.dsl.JWTConfig; import com.slk.dsl.model.User; import
 * com.fasterxml.jackson.annotation.JsonIgnore; import
 * org.springframework.security.core.GrantedAuthority;
 * 
 * import org.springframework.security.core.userdetails.UserDetails;
 * 
 * import java.util.Collection; import java.util.Date;
 * 
 * import java.util.Objects; import java.util.stream.Collectors;
 * 
 * public class UserPrincipal implements UserDetails { private Long id;
 * 
 * private String name;
 * 
 * private String username;
 * 
 * @JsonIgnore private String email;
 * 
 * @JsonIgnore private String password;
 * 
 * private Collection<? extends GrantedAuthority> authorities;
 * 
 * public UserPrincipal(int usr_Id, int lob_Id, String email_Id, String
 * password, String first_Name, String last_Name, Boolean rec_Type, Date
 * rec_Ins_Dt, Date rec_Upd_Dt) { this.id = (long) usr_Id; this.name =
 * first_Name; this.username = first_Name; this.email = email_Id; this.password
 * = password;
 * 
 * }
 * 
 * 
 * 
 * public static UserPrincipal create(User user) {
 * 
 * return new UserPrincipal( user.getUsr_Id(), user.getLob_Id(),
 * user.getEmail_Id(), user.getPassword(), user.getFirst_Name(),
 * user.getLast_Name(), user.getRec_Type(), user.getRec_Ins_Dt(),
 * user.getRec_Upd_Dt()
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * ); }
 * 
 * public Long getId() { return id; }
 * 
 * public String getName() { return name; }
 * 
 * public String getEmail() { return email; }
 * 
 * @Override public String getUsername() { return username; }
 * 
 * @Override public String getPassword() { return password; }
 * 
 * @Override public Collection<? extends GrantedAuthority> getAuthorities() {
 * return authorities; }
 * 
 * @Override public boolean isAccountNonExpired() { return true; }
 * 
 * @Override public boolean isAccountNonLocked() { return true; }
 * 
 * @Override public boolean isCredentialsNonExpired() { return true; }
 * 
 * @Override public boolean isEnabled() { return true; }
 * 
 * @Override public boolean equals(Object o) { if (this == o) return true; if (o
 * == null || getClass() != o.getClass()) return false; UserPrincipal that =
 * (UserPrincipal) o; return Objects.equals(id, that.id); }
 * 
 * @Override public int hashCode() {
 * 
 * return Objects.hash(id); } }
 */