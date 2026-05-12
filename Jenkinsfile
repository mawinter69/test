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
                    echo('Start build step')
                }
            }
        }
    }
}
