# very-simple-springxd-processor
Very simple, minimalist example of a Spring XD custom module, specifically a processor (as opposed to a source or sink)

# build
mvn clean package

# install on spring xd

    module upload --name dialect-o-matic --type processor --file /git/very-simple-springxd-processor/target/dialect-o-matic-0.0.1-SNAPSHOT.jar

Then test like this:

    module info processor:dialect-o-matic
    Information about processor module 'dialect-o-matic':
    
      Option Name  Description                                                             Default   Type
      language     What language to translate into (canadian, mexican, american-teenager)  canadian  String
      outputType   how this module should emit messages it produces                        <none>    MimeType
      inputType    how this module should interpret messages it consumes                   <none>    MimeType


Then try it out in a real stream:

    stream create --name ptest --definition "http --port=9000 | dialect-o-matic --language=canadian | log" --deploy
    Created and deployed new stream 'ptest'

    http post --target http://localhost:9000 --data "hello world"

In the log you should see "hello world, eh?"


xd:>

