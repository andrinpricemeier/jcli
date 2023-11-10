# jCLI

Build native executable CLIs using modern Java and GraalVM. Starter project to help you quickly get up to speed.

The project itself serves as an example on how to build a native executable.

## Technologies

Besides Java, GraalVM is used to produce native executables. The picocli library is used for generating
the CLI commands themselves. As a surrounding framework we use Quarkus since it offers easy integration
with GraalVM and CLI-Apps.

## Build

`mvn clean package -Dnative`

Test the output with:

`./target/jcli --help`

## Setting up Quarkus

Remove logging, clean up executable name and remove the Quarkus banner:

quarkus.banner.enabled=false
quarkus.log.level=OFF
quarkus.package.add-runner-suffix=false


Rename the final native executable to something we want:

```
<build>
    <finalName>jcli</finalName>
 ```

 ## More information

 * https://clig.dev/#guidelines


