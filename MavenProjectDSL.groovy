job('First-Maven-Project-Job-DSL'){
    description("First Maven DSL job on ${new Date()}")
    scm{
        git("https://github.com/MalchielUrias/Jenkins.git", main)
    }
    triggers{
        scm('* * * * *')
    }
    steps{
        maven('clean package', 'maven-samples/single-module/pom.xml')
    }
    publishers{
        //archiving the war file generated
        archiveArtifacts '**/*.jar'
    }
}