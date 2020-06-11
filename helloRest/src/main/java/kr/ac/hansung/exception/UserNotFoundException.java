package kr.ac.hansung.exception;

//7-2-2 14분 Serializtion 이론 설명 
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8795546082074185666L;
	private long userId;


	public UserNotFoundException(long userId) { 
		this.userId = userId;
	}


	public long getUserId() {
		return userId;
	}
}
