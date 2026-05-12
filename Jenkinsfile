properties([
    parameters([
        [$class: 'ChoiceParameter',
            choiceType: 'PT_RADIO',
            description: 'Start at which stage.',
            name: 'StartStage',
            script: [
                $class: 'GroovyScript',
                fallbackScript: [
                    classpath: [],
                    sandbox: true,
                    script: 'return ["ERROR"]'
                ],
                script: [
                    classpath: [],
                    sandbox: true,
                    script: """
                        return['Build Release:selected',
                            'Copy Release',
                            'Build Docker Image'
                        ]
                    """.stripIndent()
                ]
            ]
        ],
        [$class: 'CascadeChoiceParameter',
            choiceType: 'PT_RADIO',
            description: 'End at which stage.',
            name: 'EndStage',
            referencedParameters: 'StartStage',
            script: [
                $class: 'GroovyScript',
                fallbackScript: [
                    classpath: [],
                    sandbox: true,
                    script: 'return ["ERROR"]'
                ],
                script: [
                    classpath: [],
                    sandbox: true,
                    script: """
                        if (StartStage == 'Build Release') {
                            return['Build Release',
                                'Copy Release',
                                'Build Docker Image:selected'
                            ]
                        }
                        if (StartStage == 'Copy Release') {
                            return['Copy Release',
                                'Build Docker Image:selected'
                            ]
                        }
                        if (StartStage == 'Build Docker Image') {
                            return['Build Docker Image:selected']
                        }
                        return['ERROR']
                    """.stripIndent()
                ]
            ]
        ]
    ])
])
pipeline {
    agent any

    stages{
        stage('Build') {
            steps {
                script {
                    def versionPlatformInput = input message: 'Version and Platforms to copy', parameters: [activeChoice(choiceType: 'PT_CHECKBOX', description: 'linuxx86_64,linuxppc64le', filterLength: 1, filterable: false, name: 'platforms', script: groovyScript(fallbackScript: [classpath: [], oldScript: '', sandbox: true, script: 'return ["linuxx86_64","linuxppc64le"]'], script: [classpath: [], oldScript: '', sandbox: true, script: 'return ["linuxx86_64","linuxppc64le"]'])), string(description: 'Version to copy', name: 'version')]
                    def platforms = versionPlatformInput['platforms'].split(',')
                    for (platform in platforms) {
                        echo platform
                    }
                    echo('Start build step')
                }
            }
        }
    }
}
