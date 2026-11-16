import java.util.Scanner;

public class ClassifyRequest {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

System.out.print("Enter your ID: ");
int requestId = sc.nextInt();

System.out.print("Enter response ID: ");
int responseMS = sc.nextInt();

System.out.print("Enter Status %: ");
int status = sc.nextInt();

if (responseMS < 0 || status < 100 || status > 599) {
	System.out.println("Invalid Record");
	return;
}

System.out.println("ID: " +requestId);
System.out.println("Response Time: " +responseMS);
System.out.println("Status : " +status + "%");

if (status >= 500) {
	System.out.println("FAILED (SERVER ERROR)");
} else if (status >= 400) {
	System.out.println("FAILED (CLIENT ERROR)");
} else if (responseMS > 500) {
	System.out.println("SLOW");
} else {
	System.out.println("OK");
}

		sc.close();
	}
}