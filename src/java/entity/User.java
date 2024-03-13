package entity;
import java.util.List;

public class User {
    private Integer id;
    private String name;
    private String email;
    private String sdt;
    private String adress;
    private String pass;
    private String role;
    //OneToMany

    public User(String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSDT(){
        return sdt;
    }
    
    public void SetSDT(String sdt){
        this.sdt=sdt;
    }
    
    public String getAdress(){
        return adress;
    }
    
    public void setAdress(String adress){
        this.adress=adress;
    }

    public String getPassword() {
        return pass;
    }

    public void setPassword(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    

    public User(Integer id, String name,String email,String sdt, String adress, String pass, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.sdt = sdt;
        this.adress = adress;
        this.pass = pass;      
        this.role = role;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "user{" + "id=" + id + ", name=" + name + ", email=" + email + ", sdt=" + sdt + ", adress=" + adress + ", pass=" + pass + ", role=" + role + '}';
    }

   
    
 
    

            
}