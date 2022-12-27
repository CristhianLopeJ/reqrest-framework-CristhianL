package pojos.listUsers;

import java.util.Map;

public class DataItemListUser {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String avatar;

	public DataItemListUser(Map<String, String> data) {
		try {
			Object currentId = data.get("id");
			if (currentId instanceof Integer) {
				this.id = (int) currentId;
			}
			this.firstName = data.get("first_name");
			this.lastName = data.get("last_name");
			this.email = data.get("email");
			this.avatar = data.get("avatar");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	public String getLastName(){
		return lastName;
	}

	public int getId(){
		return id;
	}

	public String getAvatar(){
		return avatar;
	}

	public String getFirstName(){
		return firstName;
	}

	public String getEmail(){
		return email;
	}

	private void setId(Integer id) {
		this.id = id;
	}
}
