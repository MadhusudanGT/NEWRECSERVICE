package com.rec.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Scheduled")
public class SchedulesApplication {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;

@Column(name="applicantId")
private Long applicantId;

@Column(name="recuiterId")
private Long recuiterId;

@Column(name="meetingName")
private String meetingName;

@Column(name="meetingDescription")
private String meetingDescription;

@Column(name="platformLink")
private String platformLink;

@Column(name="meetingStatus")
private String meetingStatus;

@Column(name="scheduledDate")
@Temporal(TemporalType.DATE)
private Date scheduledDate;

@Column(name="scheduledTime")
@Temporal(TemporalType.TIME)
private Date scheduledTime;

public Long getId() {
	return Id;
}

public void setId(Long id) {
	Id = id;
}


public String getMeetingStatus() {
	return meetingStatus;
}

public void setMeetingStatus(String meetingStatus) {
	this.meetingStatus = meetingStatus;
}

public Long getApplicantId() {
	return applicantId;
}

public void setApplicantId(Long applicantId) {
	this.applicantId = applicantId;
}

public Long getRecuiterId() {
	return recuiterId;
}

public void setRecuiterId(Long recuiterId) {
	this.recuiterId = recuiterId;
}

public String getMeetingName() {
	return meetingName;
}

public void setMeetingName(String meetingName) {
	this.meetingName = meetingName;
}

public String getMeetingDescription() {
	return meetingDescription;
}

public void setMeetingDescription(String meetingDescription) {
	this.meetingDescription = meetingDescription;
}

public String getPlatformLink() {
	return platformLink;
}

public void setPlatformLink(String platformLink) {
	this.platformLink = platformLink;
}

public Date getScheduledDate() {
	return scheduledDate;
}

public void setScheduledDate(Date scheduledDate) {
	this.scheduledDate = scheduledDate;
}

public Date getScheduledTime() {
	return scheduledTime;
}

public void setScheduledTime(Date scheduledTime) {
	this.scheduledTime = scheduledTime;
}

public SchedulesApplication() {
	super();
}
@Override
public String toString() {
	return "SchedulesApplication [Id=" + Id + ", applicantId=" + applicantId + ", recuiterId=" + recuiterId
			+ ", meetingName=" + meetingName + ", meetingDescription=" + meetingDescription + ", platformLink="
			+ platformLink + ", scheduledDate=" + scheduledDate + ", scheduledTime=" + scheduledTime + "]";
}

public SchedulesApplication(Long id, Long applicantId, Long recuiterId, String meetingName, String meetingDescription,
		String platformLink, Date scheduledDate, Date scheduledTime) {
	super();
	Id = id;
	this.applicantId = applicantId;
	this.recuiterId = recuiterId;
	this.meetingName = meetingName;
	this.meetingDescription = meetingDescription;
	this.platformLink = platformLink;
	this.scheduledDate = scheduledDate;
	this.scheduledTime = scheduledTime;
}


}
