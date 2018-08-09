# Java library for opensubtitles.org

OpenSub4j is an open source Java library for opensubtites. It provides an object-oriented abstraction over XML-RPC opensubtitles.org API.

## Installation

Simply add the dependency to the pom.xml with the latest release:

```
<dependency>
    <groupId>com.github.pmanent</groupId>
    <artifactId>opensub4j</artifactId>
    <version>0.1.3</version>
</dependency>
```

## Usage

### Creating the client

```
URL serverUrl = new URL("https", "api.opensubtitles.org", 443, "/xml-rpc");
OpenSubtitlesClient osClient = new OpenSubtitlesClientImpl(serverUrl);
```

### Getting server info

```
ServerInfo serverInfo = osClient.serverInfo();
```

### Authentication

```
osClient.login("username", "password", "en", "TemporaryUserAgent");
(...)
osClient.logout()
```

### Search

```
// searching for subtitles matching a file
List<SubtitleInfo> subtitles = osClient.searchSubtitles("eng", new File("/path/to/file.mkv"));

// searching by imdb id
List<SubtitleInfo> subtitles = osClient.searchSubtitles("eng", "movie IMDB id");

// searching by string query + season/episode
List<SubtitleInfo> subtitles = osClient.searchSubtitles("eng", "Friends", "1", "1");
```

### Downloading subtitles

```
List<SubtitleFile> subtitleFiles = osClient.downloadSubtitles(subtitleInfo.getId());
```

## Logging

Library uses slf4j logging facade, it can be bound to any logger implementation that has bindings to slf4j. 

For binding with log4j:
```
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.25</version>
</dependency>
```

For more information please refer to slf4j documentation.

## Building from sources

To build the library from sources, you just need to invoke:
```
mvn clean package
```
Optional you can build the library without executing tests:
```
mvn clean package -DskipTests
```

Note: Java JDK 8 is required.
