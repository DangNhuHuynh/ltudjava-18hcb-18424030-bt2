package POJO;
// Generated Aug 10, 2019 3:04:01 PM by Hibernate Tools 4.3.1



/**
 * Account generated by hbm2java
 */
public class Account  implements java.io.Serializable {


     private String username;
     private String passwword;
     private Byte role;

    public Account() {
    }

	
    public Account(String username) {
        this.username = username;
    }
    public Account(String username, String passwword, Byte role) {
       this.username = username;
       this.passwword = passwword;
       this.role = role;
    }
   
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPasswword() {
        return this.passwword;
    }
    
    public void setPasswword(String passwword) {
        this.passwword = passwword;
    }
    public Byte getRole() {
        return this.role;
    }
    
    public void setRole(Byte role) {
        this.role = role;
    }




}


