package hibernate_onetoone_uni.controller;

import java.util.List;
import java.util.Scanner;

import hibernate_onetoone_uni.dao.PersonDao;
import hibernate_onetoone_uni.dto.AdharCard;
import hibernate_onetoone_uni.dto.Person;

public class PersonController {

	public static void main(String args[]) {
		
		PersonDao dao = new PersonDao();
		Person person = new Person();
		AdharCard adharcard = new AdharCard();
		
		
		Scanner sc = new Scanner(System.in);
        Scanner scstr = new Scanner(System.in);
        
		boolean flag=true;
		
		do {
			System.out.println(
					"1. Save Person\t 2.Get Person\t 3.Update Person\t 4.Delete Person\t 5.Get All Persons\t6.Exit\n");
			System.out.print("Enter Your Choice: ");
			byte choice = sc.nextByte();
			
			switch(choice)
			{
			case 1:
					{
						System.out.print("Enter Person name: ");
						String name =scstr.nextLine();
						System.out.print("Enter Person Mobile: ");
						Long mobile = sc.nextLong();
						System.out.print("Enter Person Address: ");
						String address =scstr.nextLine();
								person.setName(name);
								person.setMobile(mobile);
								person.setAddress(address);
						System.out.print("Enter Name on Adhar Card: ");
						name =scstr.nextLine();
						System.out.print("Enetr Address On Adhar Card: ");
					    address =scstr.nextLine();
						        adharcard.setName(name);
						        adharcard.setAddress(address);
						        // set person adharcard
						        person.setAdharcard(adharcard);
						        // save person 
						        dao.savePerson(person);
						        System.out.println("Person saved succefully.");	
						break;
					}
					
			case 2:
					{
						System.out.println("Enter Person Id: ");
						int id = sc.nextInt();
						person = dao.getPersonById(id);
						System.out.println(person);	
					
						break;
					}
			case 3:
					{
						System.out.print("Enetr Person Id: ");
						int id =sc.nextInt();
						person = dao.getPersonById(id);
						if(person !=null)
						{
							System.out.print("Enter New Name : ");
							String name =scstr.nextLine();
							System.out.print("Enter New Mobile Number: ");
							Long mobile = sc.nextLong();
							System.out.print("Enter New  Address: ");
							String address =scstr.nextLine();
							        person.setId(id);
									person.setName(name);
									person.setMobile(mobile);
									person.setAddress(address);
							System.out.print("Enter Name on Adhar Card: ");
							name =scstr.nextLine();
							System.out.print("Enetr Address On Adhar Card: ");
						    address =scstr.nextLine();
						            int aid =person.getAdharcard().getAid();
						            adharcard.setAid(aid);
							        adharcard.setName(name);
							        adharcard.setAddress(address);
							        // set person adharcard
							        person.setAdharcard(adharcard);
							        // save person 
							        dao.savePerson(person);
							        System.out.println("Person saved succefully.");
						}
						else
						{
							System.out.println("No Person With Given Id Do You Want To Save Person.?Y/N");
							if("y" == scstr.next().toLowerCase())
							{
								dao.savePerson(person);
								System.out.print("Person Saved.");
							}
							else if("n" == sc.next().toLowerCase())
							{
								System.out.print("Person Not Saved.");
							}
							else
							{
								System.out.print("Sorry I Dont Understand ? Y/N"+(char)1);
							}
						}
						break;
					}
			case 4:
					{
						System.out.print("Enter Person Id to Delete: ");
						int id = sc.nextInt();
						person =dao.deletePerson(id);
						
						if(person != null)
						{
						   System.out.print("Person deleted "+person);	
						}
						else
						{
							System.out.println("No Person with Give Id.");
						}
						break;
					}
			case 5:
					{
						List<Person> list =dao.getAllPersons();
						System.out.print(list);
						break;
					}
			case 6:
					{
						flag=false;
						break;
					}
			default:
					{
						flag=false;
					}
			}

		} while (flag);
	}
}
