
public class PageGEn {
	private PageGEn(){};
	
	private  static String HTML;
	private  static void setHtml(){
		HTML =  "<script>";
		HTML += "function fresh() {";
		HTML += "location.reload();";
		HTML += "}";
		HTML += "setInterval('fresh()',5000);";
		HTML += "</script>";
		HTML += "<h1>!!as!!!da!!</h1>";
	}
	public static String getHtml(){
		if(HTML == null){
			setHtml();
		}
		
		return HTML;
		
	}

}
