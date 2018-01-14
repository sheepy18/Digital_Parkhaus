package classes.models;

import java.util.HashMap;
import java.util.Map;

public class Multiton {

	private static final Map<String, Multiton> instances = new HashMap<String, Multiton>()
	{{put("PKW", null);
	put("Pickup", null);
	put("SUV", null);
	put("Zweirad", null);
	put("Trike", null);
	put("Quad", null);
	}};
	private float flaeche;
	private float gebuehr;

    private Multiton(float flaeche, float gebuehr) {
        this.flaeche = flaeche;
        this.gebuehr = gebuehr;
    }

    public static Multiton getInstance(String key, float flaeche, float gebuehr) {
        synchronized (instances) {

            if (!instances.containsKey(key)) throw new java.lang.IllegalArgumentException("this key isn't allowed");
        	
        	// Zu key gehörige Instanz aus Map holen
            Multiton instance = instances.get(key);

            if (instance == null) {
                // Lazy Creation, falls keine Instanz gefunden
                instance = new Multiton(flaeche, gebuehr);

                instances.put(key, instance);
            }

            return instance;
        }
    }

	public float getFlaeche() {
		return flaeche;
	}

	public void setFlaeche(float flaeche) {
		this.flaeche = flaeche;
	}

	public float getGebuehr() {
		return gebuehr;
	}

	public void setGebuehr(float gebuehr) {
		this.gebuehr = gebuehr;
	}
    
    
}
