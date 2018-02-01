package kerimbiber.kerimovic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author Kerimovic
 *
 */
@RestController
public class RESTServisi {
	 private static final List<Haber> HABER = new ArrayList<Haber>();
	    
	    private Object kilit = new Object();
	    /**
	     * 
	     * @param haberadi
	     * @param icerik
	     * @return
	     */
	    @RequestMapping("/haber/olustur")
	    public synchronized Haber ogrenciOlustur(String haberadi, String icerik){
	        synchronized (kilit) {
	            Haber haber = new Haber(haberadi, icerik);
	            HABER.add(haber);
	            return haber;
	        }
	    }
	    /**
	     * 
	     * @return
	     */
	    @RequestMapping("/haber/listele")
	    public synchronized List<Haber> ogrenciListele(){
	        synchronized (kilit) {
	            if (HABER.size()>10) {
	                return HABER.subList(0, 10);
	            } else {
	                return HABER;
	            }
	            
	        }
	    }
	    /**
	     * 
	     * @return
	     */
	    @RequestMapping("/haber/sil")
	    public String haberTemizle(){
	        synchronized (kilit) {
	            HABER.clear();
	            return "Haberler silindi.";
	        }
	    }


}
