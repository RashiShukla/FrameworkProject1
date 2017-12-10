package generic;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;




public class Lib implements IAutoContsant {
	
	private static final String Coulmn = null;
	public static String getProperty(String CONFIG_PATH, String key)
	{String Property="";
	
		Properties prop= new Properties();
		try{
		prop.load(new FileInputStream(CONFIG_PATH)); 
			
		
			Property=prop.getProperty(key);
		}
		catch(Exception e)
		{
		
	}return Property;
	}
public static int getRowCount(String EXCEL_PATH, String sheet)
{
	int rowCount=0;
	try {
		Workbook wb= WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
		rowCount=wb.getSheet(sheet).getLastRowNum();
				} catch (Exception e) {
		// TODO: handle exception
	}
	return rowCount;
	
	}public static String getCellValue(String EXCEL_PATH,String Sheet,int row,int column)
{ 
		String value="";
try{
	Workbook wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
	value= wb.getSheet(Sheet).getRow(row).getCell(column).toString();
}catch(Exception e)
{
	
}return value;
}		
}
	
