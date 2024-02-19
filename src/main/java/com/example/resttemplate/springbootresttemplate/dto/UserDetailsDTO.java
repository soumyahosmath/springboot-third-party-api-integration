package com.example.resttemplate.springbootresttemplate.dto;

public class UserDetailsDTO {
	
	 private String latitude;
	    private String longitude;
	    private String companyName;
		public String getLatitude() {
			return latitude;
		}
		public void setLatitude(String latitude) {
			this.latitude = latitude;
		}
		public String getLongitude() {
			return longitude;
		}
		public void setLongitude(String longitude) {
			this.longitude = longitude;
		}
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public UserDetailsDTO(String latitude, String longitude, String companyName) {
			super();
			this.latitude = latitude;
			this.longitude = longitude;
			this.companyName = companyName;
		}
		public UserDetailsDTO() {
			super();
		}


}
