# SquadFinder APP

Un cop iniciada l'app apareix la pantalla d'inici de sessió des de la qual es pot anar a la pantalla de registre,
per afegir usuaris ho fem manualment afegint-los al fitxer "users.txt" (Amb l'usuari "a", contrasenya "a" es pot entrar).
El fitxer "users.txt" es troba dins de  "SquadFinder\app\src\main\assets", en el fitxer de text podem trobar els diferents usuaris registrats. Per iniciar sessió hem de posar el nom d'usuari (primera columna) o l'email (segona columna) i la contrasenya (tercera columna).

Un cop iniciada la sessió apareix la llista d'esdeveniments disponibles, amb la barra de navegació inferior es pot accedir a les diferents pantalles (llistat d'esdeveniments, llistat de grups, els meus grups i esdeveniments i SquadFinder Pro).

En el llistat d'esdeveniments, prement sobre l'últim esdeveniment ("Mitja Marató de Barcelona") es pot entrar al detall d'aquest per veure com és el detall d'un esdeveniment.
	- Dintre el detall d'un esdeveniment si no ets participant es pot compartir o unir-se (no canvia res a part dels botons quan t'uneixes o abandones, ja que no tenim base de dades).
	- Prement el botó per unir-se apareix botó per abandonar i botó de xat.
		- Amb el botó abandonar desapareix el botó de xat.
		- Amb el botó xat anem a la pantalla xat del grup (hem fet que respongui automàticament de forma simple)

El xat hem fet que un bot automatitzat respongui a preguntes de forma simple, per tal de fer-lo una mica més interactiu i "viu".
Les preguntes que se li poden formular són les següents:
* "hola" o "ei"
- "que tal" o "com estas"
	- "hora"
	- "obre google"
	- "busca" més una cadena de busqueda (e.g. "gats") ==> busca "gats" a google
	- "resol" més una simple operació (e.g. "4 + 2") ==> resol l'operació (només operacions simples)
	- "flip coin" ==> retorna cara o creu
Cada una de les opcions anteriors retorna una resposta, en el cas que el bot no entengui que li demana l'usuari retornarà un missatge dient que no ho ha entès.
Les preguntes no tenen en consideració els accents. En l'informe hi ha una explicació una mica més detallada en el punt 11.

En el llistat de grups, prement sobre el grup "Lliga de debat UPF" entrem al detall d'un grup, molt semblant al detall d'un esdeveniment.
	- Podem unir-nos i abandonar i entrar al xat per consultar amb l'organitzador.
	
En els meus Grups i Esdeveniments ("Meus G/E") tenim:
	- Calendari a la part superior.
	- Els meus Grups:
		- Hem afegit el grup Lliga de debat suposant que s'hi pertany.
		- Un segon grup (Admin) creat per l'usuari que utilitza l'app.
			- Entrant al grup veiem que és diferent a la vista normal de grup afegint botons.
			  Tenim un botó per editar el grup, destacar-lo, compartir i accedir al xat (Accedir al xat és l'únic funcional)
			  En el llistat d'usuaris es té l'opció d'eliminar usuaris o sortir del grup passant a ser admin un altre membre.

En la pantalla PRO només tenim una explicació del que és, i un botó amb el que començar el període de prova.

Moltes funcionalitats només estan com a disseny, ja que sense base de dades (falta de temps i coneixement) no es poden aplicar.
