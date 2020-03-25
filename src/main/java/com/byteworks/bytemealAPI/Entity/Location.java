package com.byteworks.bytemealAPI.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Location {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String address;
  private double longitude;
  private double latitude;

  Location() {}

  public Location(String address, Double longitude, double  latitude) {
    this.longitude = longitude;
    this.latitude = latitude;
  }

  @OneToOne(mappedBy = "location")
  private Vendor vendor;

  @OneToOne(mappedBy = "location")
  private Developer developer;

  public double getLatitude() {
    return latitude;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    
    this.address = address;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }
 
 

  // return distance between this location and that location
  // returned in meters
  public double distanceTo(Location that) {
      double STATUTE_MILES_PER_NAUTICAL_MILE = 1.15077945;
      double lat1 = Math.toRadians(this.latitude);
      double lon1 = Math.toRadians(this.longitude);
      double lat2 = Math.toRadians(that.latitude);
      double lon2 = Math.toRadians(that.longitude);

      // great circle distance in radians, using law of cosines formula
      double angle = Math.acos(Math.sin(lat1) * Math.sin(lat2)  + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));

      // each degree on a great circle of Earth is 60 nautical miles
      double nauticalMiles = 60 * Math.toDegrees(angle);
      double statuteMiles = STATUTE_MILES_PER_NAUTICAL_MILE * nauticalMiles;

       //convert miles to meters 
        double distanceToKm = statuteMiles * 1.60934;
        double distanceMeter =distanceToKm * 1000;

      return distanceMeter;
  }


  // return string representation of this point
  public String toString() {
      return address + " (" + latitude + ", " + longitude + ")";
  }


    

}