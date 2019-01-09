/**
 * 
 */
package com.Casestudy.Models;

/**
 * @author amahome
 *
 */
public class AddressRelation {
	private int relationId;
	private String relationLink;
	/**
	 * @param relationId
	 * @param relationLink
	 */
	public AddressRelation(int relationId, String relationLink) {
		super();
		this.relationId = relationId;
		this.relationLink = relationLink;
	}
	/**
	 * @return the relationId
	 */
	public int getRelationId() {
		return relationId;
	}
	/**
	 * @param relationId the relationId to set
	 */
	public void setRelationId(int relationId) {
		this.relationId = relationId;
	}
	/**
	 * @return the relationLink
	 */
	public String getRelationLink() {
		return relationLink;
	}
	/**
	 * @param relationLink the relationLink to set
	 */
	public void setRelationLink(String relationLink) {
		this.relationLink = relationLink;
	}
	
	

}
