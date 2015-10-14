package de.hhbk.de.cb.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import de.hhbk.de.cb.model.Lesson;
import de.hhbk.de.cb.model.Pupil;
import de.hhbk.de.cb.model.SchoolClass;
import de.hhbk.de.cb.model.SchoolSubject;

/**
 * Created by dominik on 14.10.15.
 */
public class DummyDataLand {
    private Map<String, SchoolClass> schoolClassMap;
    private static DummyDataLand ourInstance = new DummyDataLand();

    private DummyDataLand() {
        schoolClassMap = buildClasses();
    }

    private Map<String, SchoolClass> buildClasses() {
        Map<String,SchoolClass> schoolclasses = new HashMap<>();
        String[] classnames = {"FUU 02","BAA", "YOLO", "HHBK"};
        String[] lastnames = {"Agalisiore", "Athoe", "Briususaili", "Faumeti", "Gent", "Hocacn", "Jotanic", "Lyber", "Moimarileio", "Moion", "Nenchio", "Oeoron", "Pesia", "Pial", "Polceronu", "Rtheg", "Tesisthr", "Usarole", "Usoeod", "Ymonod","Bisse",
                "Disicrumuri", "Duturidi", "Entag", "Farampre", "Ganasi", "Gertheusiu", "Icis", "Iolyr", "Joprtan", "Lasclaba", "Osthusares", "Regarp", "Rsmnteth", "Sion", "Ticoner", "Usica", "Vialic", "Ytusilu", "Zenot"};
        String[] fornames = {"Astral Dancer", "Jasminebeats", "Amethyst Tinsel", "Berryjoe", "Pumpkin Set", "Bubble Blazer", "Dream Dasher", "Amethyst Toffee", "Foresthunt", "Hazel Vinyl", "Laughmarch", "Lemon Sparkle", "Polishfly", "Persimmonsstrudel Breeze", "Rainbow Voyager", "Rainbow Sweets", "Shore Lightning", "Silk Rocket", "Stampbuds", "Twilight Rhyme",
                "Charming Starlight", "Star Ashes", "Emeraldaura", "Evening Light", "Shadeflurry Punch", "Treasurepop", "Jade Flame", "Joy Pastels", "Mahogany Sage", "Marble Riff", "Meadow Toffee", "Moonlight Twirler", "Peach Break", "Rain Gears", "Route Will", "Scrolldrop", "Spring Masher", "Timelink", "Trickssky", "Wave Sweets"};
        String[] subjects = {"Afrikanistik", "Albanologie", "Allgemeine Sprachwissenschaft", "Allgemeine und Vergleichende Literaturwissenschaft", "Altamerikanistik", "Alte Geschichte", "Altorientalistik", "Angewandte Kernphysik, ein Sammelbegriff für Kerntechnik und ähnliche energienahe Studiengänge", "Anthropologie", "Arabistik", "Arbeitswissenschaft", "Astronomie", "Astrophysik", "Austronesistik", "Baltistik", "Bauforschung/Baugeschichte", "Bibliothekswissenschaft", "Bioinformatik", "Biophysik", "Buchwissenschaft", "Byzantinistik", "Christlicher Orient", "Computerlinguistik", "Denkmalpflege", "Eisenbahnwesen", "Europäische Ethnologie/Volkskunde", "Filmwissenschaft", "Finnougristik und Uralistik", "Frisistik", "Gender Studies", "Geochemie", "Geophysik", "Gerontologie", "Geschichte der Medizin", "Hauswirtschaftswissenschaft", "Historische Hilfswissenschaften", "Indische Kunstgeschichte", "Indogermanistik", "Indologie", "Informationswissenschaft", "Iranistik", "Islamische Kunstgeschichte", "Islamwissenschaft", "Japanologie", "Jiddistik", "Journalistik", "Judaistik", "Kanadistik", "Kaukasiologie", "Keltologie", "Klinische Linguistik", "Koptologie", "Koreanistik",
                "Kristallographie", "Landes- und Regionalgeschichte", "Lateinamerikanistik", "Latinistik", "Logik und Wissenschaftstheorie", "Lusitanistik", "Medieninformatik", "Meereskunde", "Metallurgie", "Meteorologie", "Mineralogie", "Mittellatein", "Mongolistik", "Museologie", "Neurolinguistik",
                "Niederlande-Studien", "Niederlandistik", "Ostasiatische Kunstgeschichte", "Ostasienwissenschaft", "Osteuropäische Geschichte", "Osteuropastudien", "Papyrologie", "Phonetik", "Religionswissenschaft", "Restaurierungswissenschaft", "Schiffstechnik", "Semitistik",
                "Sexualwissenschaft", "Sinologie", "Skandinavistik/Nordistik", "Slavistik", "Sorabistik", "Sprachlehrforschung", "Sprechwissenschaft", "Tanzwissenschaft", "Technikgeschichte", "Textilgestaltung", "Thaiistik", "Theaterwissenschaft", "Tibetologie", "Translatologie", "Turkologie", "Umformtechnik", "Ur- und Frühgeschichte", "Vietnamistik", "Wirtschafts- und Sozialgeschichte", "Wissenschaftsgeschichte"};

        for(int i = 0; i<4; i++){
            SchoolClass schoolClass = new SchoolClass(classnames[i]);

            for(int j = 10*i; j<10*(i+1); j++) {
                debug.getInt().message("Klasse: "+classnames[i]+" j: "+j+" name: "+fornames[j]+" "+lastnames[j]);
                Pupil pupil = new Pupil();
                pupil.setForname(fornames[j]);
                pupil.setLastname(lastnames[j]);
                pupil.setSchoolClass(schoolClass);
                schoolClass.addPupil(pupil);
            }
            for(int k=0; k<10; k++) {
                Random random = new Random();
                String subjectname = subjects[random.nextInt(subjects.length)];
                debug.getInt().message("Klasse: : "+classnames[i]+" Fach: "+subjectname);
                SchoolSubject subject = new SchoolSubject(subjectname, schoolClass);
                schoolClass.addSchoolSubject(subject);
            }

            schoolclasses.put(schoolClass.getClassname(), schoolClass);
        }
        return schoolclasses;
    }
    private String[] makeStringsOutOfClasses(Map<String,SchoolClass> classes) {
        String[] result = new String[classes.size()];
        result = classes.keySet().toArray(result);
        return result;
    }

    public static DummyDataLand getInt() {
        return ourInstance;
    }

    public Map<String, SchoolClass> getSchoolClassMap() {
        return schoolClassMap;
    }

    public String[] getValues() {
        return makeStringsOutOfClasses(schoolClassMap);
    }
    public SchoolClass getSchoolClassByName(String name) {
        if (schoolClassMap.containsKey(name)) {
            SchoolClass theChosenOne = schoolClassMap.get(name);
            return theChosenOne;
        }
        return null;
    }
}
