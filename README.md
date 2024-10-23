De descris în limbajul Java ierarhia de clase Om  →   User →    Administrator →   Șefu_Mare
De descris interfata. De implementat interfața în cîteva clase din ierarhie.

clasa Om
	câmpuri:
variabilă statică, care arată statutul social = {”om”, ”user”, ”admin”, ”boss” }
câmp de tip întreg, care arată înălțimea Omului
câmp șir de caractere, care descrie culoarea ochilor Omului 
câmp de tip real, care păstrează greutatea Omului
câmp de tip logic, care descrie sexul Omului
	funcții:
câțiva constructori (implicit (completarea campurilor cu valori aleatoare) și cu parametri)
funcțiile de acces la câmpurile clasei, și funcțiile de setare a lor
funcția de afisare a câmpurilor clasei la ecran
funcția abstracta void saveObjectToFile (String nameFile)

class User extends Om
câmpuri:
câmp de tip întreg, care arată numărul de drepturi de acces pentru User
vector dinamic, în care se păstrează informația despre fiecare drept de acces al Userului
funcții:
câțiva constructori (implicit și cu parametri) cu apelarea la constructorii din clasa parinte.
funcțiile de acces la câmpurile clasei, și funcțiile de setare a lor
redescrierea a functiei de afisare

class Admin extends User
câmpuri:
câmp de tip real, care arată coeficientul de lene al Adminului (de la 0 la 1)
2 câmpuri de tip real, care arată IQ Administratorului și salariul Administratorului 
funcții:
câțiva constructori (implicit (completarea campurilor cu valori aleatoare) și cu parametri)
funcțiile de acces la câmpurile clasei, și funcțiile de setare a lor
redescrierea a functiei de afisare 
funcția de limitare a drepturilor de acces ale Userului, transmis ca parametru în fucnție. (adică nulificarea vectorului Userului)
funcția de adunare (de tip final) a doi Administratori (noul Administrator va avea media aritmetică dintre lenea ambilor operanzi, media aritmetică IQurilor lor și reuniunea drepturilor de acces ale lor)

class Șefu_Mare extends Admin
câmpuri:
câmp de tip real, care arată numărul de subalterni ai Șefului_Mare
vector dimanic, în care se păstrează Iqurile subalternilor Șefului_Mare
funcții:
câțiva constructori (implicit (completarea campurilor cu valori aleatoare) și cu parametri)
funcțiile de acces la câmpurile clasei, și funcțiile de setare a lor
redescrierea a functiei de afisarea a câmpurilor clasei la ecran
funcția, care setează salariul nou unui Administrator concret, transmis ca parametru în funcție (salariul se mărește, dacă raportul dintre lenea si IQ Administratorului  e mai mică ca 1, altfel – se micșorează)
funcția de concediere Administratorului concret în cazul, dacă raportul dintre lenea si IQ Administratorului  e mai mare ca 100 (în același timp schimbînd numărul de subalterni ai Șeful_Mare)
funcția de înmulțire :) (noul Șef va avea numărul subalternilor egal cu produsul subalternilor ambilor operanzi)

interface
funcții:
funcția de afisare a câmpurilor clasei la ecran

main
de creat vectorul dinamic cu exemplarele ”viețuitoarelor” de oficiu descrise mai sus, dând ca tipul de bază – clasa origine, și de inițializat aceste elemente cu obiectele tuturor claselor moștenite. Dupa ce de utilizat in main numai obiectele din acest vector. 
de afișat la ecran câmpurile tuturor obiectelor create
de limitat drepturile de acces unui user folosind funcțiile unui admin. Drepturile noi de afișat la ecran.
un Șef trebuie să controleze toți adminii la raportul dintre IQ și lene, și sau să concedieze, sau să facă ceva cu salariul fiecaruia :). Salariile noi ale adminilor de afișat la ecran.
de ”adunat” câțiva admini. De ”înmulțit” câțiva Șefi.
de comparat câțiva șefi la deșteptăciunea totală a subalternilor fiecăruia. Rezultatul de afișat la ecran și de a-l salva în fișier textual.
