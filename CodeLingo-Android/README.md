# CodeLingo – Android-App

Programmiersprachen spielerisch lernen – als echte Android-App, ohne Website.
Die komplette Lern-App liegt in `app/src/main/assets/index.html` und läuft offline.

## APK bauen lassen (GitHub, nichts installieren)

1. Auf [github.com](https://github.com) ein **neues Repository** anlegen (z. B. `codelingo-app`, „Private“ ist okay).
2. Auf der Repository-Seite **„uploading an existing file“** wählen und den **Inhalt** dieses Ordners
   hineinziehen (also `app/`, `.github/`, `build.gradle.kts` … – nicht den Ordner `android-app` selbst).
   → „Commit changes“.
3. Im Tab **Actions** läuft jetzt „APK bauen“ (ca. 3–5 Minuten).
4. Danach rechts unter **Releases** die neueste Version öffnen und **CodeLingo.apk** herunterladen –
   am einfachsten direkt auf dem Handy.
5. Auf dem Handy die APK öffnen und **„Installation aus unbekannten Quellen“** für den Browser erlauben.

> Falls der Ordner `.github` beim Hochladen fehlt (manche Browser überspringen Ordner mit Punkt):
> „Add file“ → „Create new file“, als Namen `.github/workflows/build-apk.yml` eintippen und
> den Inhalt der gleichnamigen Datei hineinkopieren.

## Updates

Neue Version von `index.html` nach `app/src/main/assets/` hochladen → GitHub baut automatisch eine
neue APK. Sie lässt sich über die alte installieren, der Lernfortschritt bleibt erhalten
(dafür sorgt der feste Schlüssel `app/codelingo.keystore`).

## Hinweise

- **Internet** braucht die App nur für echtes Python und TypeScript (einmaliger Download)
  und für die Schriftarten – alles andere, auch SQL, läuft offline.
- Der Schlüssel `codelingo.keystore` ist nur für den privaten Gebrauch gedacht. Für eine
  Veröffentlichung im Play Store einen eigenen, geheimen Schlüssel erzeugen.
- Mit **Android Studio** lässt sich das Projekt ebenfalls direkt öffnen und bauen.
