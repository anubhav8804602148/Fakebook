import os
from PIL import Image
allFiles = os.listdir(".")
for file in allFiles:
    if "png" in file:
        img = Image.open(file).convert("RGBA")
        pixels = img.load()
        w,h = img.size
        for i in range(w):
            for j in range(h):
                pix = img.getpixel((i,j))
                img.putpixel((i,j),(pix[2],pix[1],pix[0],pix[3]))
        img.show()
        img.save(file)