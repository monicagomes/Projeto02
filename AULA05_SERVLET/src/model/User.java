package model;

public class User {
	  private int id;
	   private String plate;
	   private String name;
	   private String cpf;
	   private String rg;
	   private String address;
	   private String phone;
	   private String email;
	   private String function;
	   private String group;
	   
	   public User() {
	      //this(0,"","","","","","","","",0);
	   }
	   
	   /*public User(String plate, String cpf, int group) {
	      this();
	      this.setPlate(plate);
	      this.setCpf(cpf);
	      this.setGroup(group);
	   }
	   
	   public User(String plate,String name,
	               String cpf, String rg,
	               String address, String phone,
	               String email, String function,
	               int group) {
	      this.setPlate(plate);
	      this.setName(name);
	      this.setCpf(cpf);
	      this.setRg(rg);
	      this.setAddress(address);
	      this.setPhone(phone);
	      this.setEmail(email);
	      this.setFunction(function);
	      this.setGroup(group);
	   }*/
	   
	   //sets
	   public void setId(int id) {
		   this.id= id;
	   }
	   public void setPlate(String plate) {
	      this.plate = plate;
	   }
	   
	   public void setName(String name) {
	      this.name = name;
	   }
	   
	   public void setCpf(String cpf) {
	      this.cpf = cpf;
	   }
	   
	   public void setRg(String rg) {
	      this.rg = rg;
	   }
	   
	   public void setAddress(String address) {
	      this.address = address;
	   }
	   
	   public void setPhone(String phone) {
	      this.phone = phone;
	   }
	   
	   public void setEmail(String email) {
	      this.email = email;
	   }
	   
	   public void setFunction(String function) {
	      this.function = function;
	   }
	   
	   public void setGroup(String group) {
	      this.group = group;
	   }
	   
	   //gets
	   public int getId() {
		   return id;
	   }
	   
	   public String getPlate() {
	      return plate;
	   }
	   
	   public String getName() {
	      return name;
	   }
	   
	   public String getCpf() {
	      return cpf;
	   }
	   
	   public String getRg() {
	      return rg;
	   }
	   
	   public String getAddress() {
	      return address;
	   }
	   
	   public String getPhone() {
	      return phone;
	   }
	   
	   public String getEmail() {
	      return email;
	   }
	   
	   public String getFunction() {
	      return function;
	   }
	   
	   public String getGroup() {
	      return group;
	   }

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", matricula=" + plate + ", nome=" + name 
				+ ", fone=" + phone + ", cpf=" + cpf + ", rg=" + rg + ", email=" 
				+ email + ", endereco=" + address + ", funcao=" + function 
				+ ", conjunto=" + group +"]";
	}

}
