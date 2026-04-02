# 🚀 DEPLOYMENT GUIDE - GET YOUR LIVE LINK

## STEP 1: Push to GitHub
```bash
git init
git add .
git commit -m "AI Resume Screener - Ready for deployment"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/ai-resume-screener.git
git push -u origin main
```

## STEP 2: Go to Render.com
1. Visit: https://dashboard.render.com/
2. Sign up with GitHub (if not already)
3. Click **"+ New"** → **"Web Service"**

## STEP 3: Connect Repository
1. Select **"Build and deploy from a Git repository"**
2. Choose **ai-resume-screener** repo
3. Fill in:
   - **Name:** `ai-resume-screener`
   - **Runtime:** Docker
   - **Plan:** Free (no credit card needed)

## STEP 4: Set Environment (Optional)
- Key: `PORT`
- Value: `10000`

## STEP 5: Deploy
1. Click **"Create Web Service"**
2. Render builds & deploys automatically
3. Wait 3-5 minutes for build to complete

## YOUR LIVE LINK
Once deployed, you'll get:
```
https://ai-resume-screener-xxxxx.onrender.com/
```

### Access your app:
- **Frontend:** `https://ai-resume-screener-xxxxx.onrender.com/`
- **API:** `https://ai-resume-screener-xxxxx.onrender.com/api/v1/screen`

---

## ⚙️ GitHub Actions Setup (Auto-deploy on push)

After deployment on Render, add these secrets to GitHub:

1. Go to repo → **Settings** → **Secrets and variables** → **Actions**
2. Add:
   - `RENDER_SERVICE_ID` — from Render dashboard URL
   - `RENDER_API_KEY` — from Render account settings

Then every push to `main` auto-deploys!

---

## 🛠️ Files Ready to Deploy
✅ Dockerfile — Docker build config
✅ render.yaml — Render deployment config
✅ .dockerignore — Optimize build
✅ index.html — Frontend UI
✅ Backend APIs — Ready to serve

**Status: Ready to deploy! 🚀**
