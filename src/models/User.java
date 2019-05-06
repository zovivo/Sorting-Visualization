package models;

public class User {
	private int id;
	private String userName;
	private String phonenumber;
	float value;

	public User(String phonenumber , String userName) {
		super();
		this.userName = userName;
		this.phonenumber = phonenumber;
		String[] word = userName.split("\\s+");
		String Ho="";
		String Tendem=""+word[word.length-2];
		String Ten=""+word[word.length-1];
		value = Ten.compareTo("A")*25*25+(Tendem.compareTo("A")*25)+(Ho.compareTo("A"));

		for (int i = 0; i < word.length; i++) {
			if(i<(word.length-2))
				Ho =Ho +word[i]+" ";
		}
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	
	public float getValue() {
		return value;
	}


	public void setValue(float value) {
		this.value = value;
	}

   


	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public int compareTo(Object obj) {
		User user = (User) obj;
		
		if(getValue()>user.getValue())
			return 1;
		else if(getValue()<user.getValue())
			return -1;
		return 0;
			
		
	}

}
