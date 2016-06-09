package Final.Controller;

import org.springframework.stereotype.Component;

import Final.Model.MemberInfo;


@Component
public class MockAuthenticator implements Authenticator {

	public void authenticate(String id, String password) {
		// TODO Auto-generated method stub
		if (!id.equals("madvirus")) {
			throw new AuthenticationException("invalid id "+id);
		}
	}
	public int authenticate(MemberInfo memberInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

}


