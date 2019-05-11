package kr.or.bit.action;

public class ActionForward {
	private String path=null;//이동 경로
	private boolean isRedirect = false;
	
		public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}

	}

