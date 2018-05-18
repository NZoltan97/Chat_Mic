package com.ticketninja.pilot.util;

public enum Status {
	
	 OK(1, "ok"),
	 INVALIDORGNAME(2, "Invalid organization name"),
	 INVALIDZIPCODE(3, "Invalid zip code"),
	 INVALIDSETTLEMENT(4, "Invalid settlement"),
	 INVALIDSTREET(5, "Invalid street"),
	 INVALIDHNUMBER(6, "Invalid house number"),
	 INVALIDNAME(7, "Invalid name"),
	 INVALIDCHECKSUM(8, "Invalid checksum"),
	 ALREADYFOUNDMAILADDRESS(9, "The given e-mail addres is already in use"),
	 INVALIDCOMMENT(10, "Invalid comment"),
	 MAILADDRESSNOTFOUND(11, "Cannot found e-mail address"),
	 USERIDNOTFOUND(12, "Cannot found user"),
	 INVALIDMAILCONTENT(13, "Invalid mail content"),
	 INVALIDEVENTNAME(14, "Invalid event name"),
	 INVALIDDATE(15, "Invalid date"),
	 FILENOTFOUND(16, "File not found");
	

     private final int code;
     private final String description;

     Status(int code, String desc){
         this.code = code;
         this.description = desc;
     }
     
     public int code(){
         return this.code;
     }
     
     public String description(){
         return this.description;
     }
}
