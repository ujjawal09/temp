package dom.util;

public class Lgr {
//    String className;
//    String methodName;
//    String lineNumber;

/*	public static void lc() {
		Ptr.pc(getLog());
	}

	public static void lb() {
		Ptr.pb(getLog());
	}

	public static void lp() {
		Ptr.pp(getLog());
	}

	public static void ly() {
		Ptr.py(getLog());
	}

	public static void lr() {
		Ptr.pr(getLog());
	}

	public static void lg() {
		Ptr.pg(getLog());
	}*/

	public static void lc(Object message) {
		Ptr.pc(getLog(message));
	}

	public static void lb(Object message) {
		Ptr.pb(getLog(message));
	}

	public static void lp(Object message) {
		Ptr.pp(getLog(message));
	}

	public static void ly(Object message) {
		Ptr.py(getLog(message));
	}

	public static void lr(Object message) {
		Ptr.pr(getLog(message));
	}

	public static void lg(Object message) {
		Ptr.pg(getLog(message));
	}

/*	public static void lc(String message) {
		Ptr.pc(getLog(message));
	}

	public static void lb(String message) {
		Ptr.pb(getLog(message));
	}

	public static void lp(String message) {
		Ptr.pp(getLog(message));
	}

	public static void ly(String message) {
		Ptr.py(getLog(message));
	}

	public static void lr(String message) {
		Ptr.pr(getLog(message));
	}

	public static void lg(String message) {
		Ptr.pg(getLog(message));
	}*/

	public static String getLog() {
		String lineNumber = Integer.toString(Thread.currentThread().getStackTrace()[3].getLineNumber());
		String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
		Thread.currentThread().getStackTrace()[3].getClassName();
//		Class runtimeClassOfThisObject = Thread.currentThread().getStackTrace()[3].getClass();
//		String className = runtimeClassOfThisObject.getSimpleName();
//		String packageName = runtimeClassOfThisObject.getPackage().getName();
		String fullyQualifiedClassName = Thread.currentThread().getStackTrace()[3].getClassName();
		return  "@"+ fullyQualifiedClassName +" @" + lineNumber + " @" +  methodName ;
	}

	public static String getLog(Object message) {
		String lineNumber = Integer.toString(Thread.currentThread().getStackTrace()[3].getLineNumber());
		String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
		Thread.currentThread().getStackTrace()[3].getClassName();
//		Class runtimeClassOfThisObject = Thread.currentThread().getStackTrace()[3].getClass();
//		String className = runtimeClassOfThisObject.getSimpleName();
//		String packageName = runtimeClassOfThisObject.getPackage().getName();
		String fullyQualifiedClassName = Thread.currentThread().getStackTrace()[3].getClassName();
		return "^" + message + "^ @"+ fullyQualifiedClassName +" @" + lineNumber + " @" +  methodName ;
	}
}
