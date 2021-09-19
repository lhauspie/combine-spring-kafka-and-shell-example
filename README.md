# Combine Spring Batch and Spring Shell

The purpose of this repo is to show how to combine Spring Batch and Spring Shell to make batchs runnable from command lines in Shell.

## How to build

```
$ mvn clean package
```

## How to run

```
$ java -jar target/combine-spring-batch-and-shell-example-0.0.1-SNAPSHOT.jar
```

After the jar is running, you are prompted to run the commands.
Just type `help` to display the possible commands.

After reading the help, you can run the Spring Batch by typing the following command:

```
shell:>import-user --parameter toto
```

Here, the `--parameter` is here to make the job failing if you run the Spring Batch twice with the same parameter as we can see in this example:

```
shell:>import-user --parameter toto
java.lang.reflect.UndeclaredThrowableException
Details of the error have been omitted. You can use the stacktrace command to print the full stacktrace.

shell:>stacktrace
[...]
Caused by: org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException: A job instance already exists and is complete for parameters={param=toto, filter=}.  If you want to run this job again, change the parameters.
[...]
```

## Additional feature

To make the Job failing you can set the `--filter` parameter with a `firstName` present in the `sample-data.csv` file.
```
shell:>import-user --parameter toto --filter John
```

Note that the `--filter` parameter is not part of the Spring Batch Identifier.

So running 
```
shell:>import-user --parameter toto --filter titi
```
that will be `COMPLETED` then
```
shell:>import-user --parameter toto --filter John
```
that should be `FAILED` cause of filter will fail because of a `JobInstanceAlreadyCompleteException`.

