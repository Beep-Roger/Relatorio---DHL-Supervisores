import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.TimeZone;

public class Teste {

	
	
	public static void main(String[] args) {

		Supervisores supervisores = new Supervisores("select users.name, media.sendto  from users\r\n" + 
				"inner join media on media.userid = users.userid\r\n" + 
				"where users.alias like \"Richard Vieira\"");	
		
	}
		

		
}
	



