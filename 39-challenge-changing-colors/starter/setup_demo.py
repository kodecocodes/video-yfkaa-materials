# Match the video folder gitignore to the one for sample project.
# Run this from the sample project root directory.
# Set value for base_dir and branches.

import os

base_dir = '~/src/raywenderlich/team/vt_your_first_kotlin_android_app/v2/StudentMaterials'

# dictonary {directory: start_branch}
branches = {
    'p02e02-modifying-the-ui': 'p01e03-first-project',
    'p02e03-challenge-add-another-text-view': 'p02e02-modifying-the-ui',
    'p02e04-positioning-items': 'p02e03-challenge-add-another-text-view',
    'p02e05-challenge-add-a-button': 'p02e04-positioning-items',
    'p02e06-customizing-elements': 'p02e05-challenge-add-a-button',
    'p02e07-challenge-customize-text-view': 'p02e06-customizing-elements',
    'p02e08-string-resources': 'p02e07-challenge-customize-text-view',
    'p02e09-challenge-string-resources': 'p02e08-string-resources',
    'p03e04-adding-activity-properties': 'p02e09-challenge-string-resources',
    'p03e05-challenge-add-a-property': 'p03e04-adding-activity-properties',
    'p03e07-handling-actions': 'p03e05-challenge-add-a-property',
    'p03e08-challenge-update-text-view': 'p03e07-handling-actions',
    'p03e09-adding-the-countdown-timer': 'p03e08-challenge-update-text-view',
    'p03e10-starting-and-ending-the-game': 'p03e09-adding-the-countdown-timer',
    'p04e02-your-first-debug': 'p03e10-starting-and-ending-the-game',
    'p04e03-handling-orientation-change': 'p04e02-your-first-debug',
    'p04e06-saved-state': 'p04e03-handling-orientation-change',
    'p05e02-changing-color': 'p04e06-saved-state',
    'p05e03-challenge-changing-colors': 'p05e02-changing-color',
    'p05e04-animations': 'p05e03-challenge-changing-colors',
    'p05e05-challenge-add-an-animation': 'p05e04-animations',
    'p05e06-add-a-menu': 'p05e05-challenge-add-an-animation',
    'p05e07-about-dialog': 'p05e06-add-a-menu',
    'p05e08-app-icon-and-display-name': 'p05e07-about-dialog',
}


def setup_branch(end_branch, start_branch):
    part = "part{}".format(end_branch[2])
    pre_recording_start_dir_name = "{}/pre-recording/{}/{}/begin".format(
        base_dir, part, end_branch)
    pre_recording_end_dir_name = "{}/pre-recording/{}/{}/end".format(
        base_dir, part, end_branch)
    recording_start_dir_name = "{}/recording/{}/{}/begin".format(
        base_dir, part, end_branch)

    os.system("mkdir -p {}".format(pre_recording_start_dir_name))
    os.system("mkdir -p {}".format(pre_recording_end_dir_name))
    os.system("mkdir -p {}".format(recording_start_dir_name))

    os.system("git checkout {}".format(start_branch))
    os.system("cp -r * {}".format(pre_recording_start_dir_name))
    os.system("cp -r * {}".format(recording_start_dir_name))
    os.system("git checkout {}".format(end_branch))
    os.system("cp -r * {}".format(pre_recording_end_dir_name))


for directory in branches:
    setup_branch(directory, branches[directory])
