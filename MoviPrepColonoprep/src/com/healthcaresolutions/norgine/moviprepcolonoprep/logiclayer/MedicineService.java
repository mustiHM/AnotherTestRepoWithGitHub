package com.healthcaresolutions.norgine.moviprepcolonoprep.logiclayer;

import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Medicine;

/**
 * Bietet Dienste zur Verwaltung des eingesetzten Medikaments an.
 */
public interface MedicineService {

	/**
	 * Liest die Konfig aus und gibt die Informationen über das Medikament zurück.
	 * @return das Medikament
	 */
	public Medicine getMedicineInfo();
	
}
