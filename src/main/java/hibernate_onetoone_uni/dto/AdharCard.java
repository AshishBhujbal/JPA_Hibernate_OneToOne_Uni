package hibernate_onetoone_uni.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adharcards")
public class AdharCard {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int aid;
	@Override
	public String toString() {
		return "AdharCard [aid=" + aid + ", name=" + name + ", address=" + address + "]";
	}

	private String name;
	private String address;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
