parameters {
   string(name: 'ENVIRONMENT', defaultValue: 'staging', description: 'Target deployment environment')
   string(name: 'ROLES', defaultValue: 'admin', description: 'Roles')
   choice(choices: ['a', 'b', 'c'], description: 'My choices', name: 'choice')
}
