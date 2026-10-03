import os
import re

controller_dir = r'c:\Users\ADMIN\Desktop\NCKH 26-27\Be-app-facial-recognition\src\main\java\com\example\be\web\controller'

for filename in os.listdir(controller_dir):
    if not filename.endswith('.java'): continue
    filepath = os.path.join(controller_dir, filename)
    with open(filepath, 'r', encoding='utf-8') as f:
        content = f.read()

    # Remove all @Tag annotations
    content_no_tags = re.sub(r'@Tag\s*\([^)]*\)\s*', '', content)
    
    # Generate a nice tag name from class name
    class_name = filename.replace('.java', '')
    tag_name = class_name.replace('Controller', ' Management')
    # add spaces before capital letters
    tag_name = re.sub(r'(?<!^)(?=[A-Z])', ' ', tag_name)
    tag_name = tag_name.replace(' Management', ' Management').strip()

    # Insert @Tag at class level
    class_decl_match = re.search(r'public class\s+' + class_name, content_no_tags)
    if class_decl_match:
        tag_annotation = f'@Tag(name="{tag_name}")\n'
        idx = class_decl_match.start()
        new_content = content_no_tags[:idx] + tag_annotation + content_no_tags[idx:]
        
        with open(filepath, 'w', encoding='utf-8') as f:
            f.write(new_content)
        print(f"Updated {filename}")
